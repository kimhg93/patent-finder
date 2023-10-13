<template>
    <div class="container">
        <h1>{{title}}</h1>
        <div class="tech-detail">
            <v-app id="inspire">
                <v-main>
                    <v-container>
                        <v-row>
                            <v-col v-for="(item, index) in items" :key="item.techItemNo" cols="12" sm="6" md="4">
                                <v-card height="130" @click="goTo(`/tech/${this.techItemNo}/1`)">
                                    <v-card-title class="title">{{ index+1 }}. {{ item.techItemNm }}</v-card-title>
                                </v-card>
                            </v-col>
                        </v-row>
                    </v-container>
                </v-main>
            </v-app>
        </div>
    </div>
</template>


<script>
    import axios from 'axios';

    export default {
        name: "TechDetail",
        props: ['code'],
        data() {
            return {
                items: [ ],
                title: "",
            };

        },
        computed: {

        },
        created() {
            this.fetchItemData();
        },
        methods: {
            goTo(link) {
                window.location.href = link;
            },
            async fetchItemData() {
                try {
                    const response = await axios.get(`/api/tech/${this.code}`);
                    this.items = response.data;
                    this.title = response.data[0].techFieldNm;
                } catch (e) {
                    console.error(e);
                }
            },

        }
    }


</script>

<style scoped>
    .container {
        display: flex;
        flex-direction: column; /* 요소들을 수직으로 배열 */
        align-items: center; /* 가로 방향으로 중앙 정렬 */
        justify-content: space-around;
        text-align: center; /* h1 태그 내부의 텍스트도 중앙 정렬 */
        overflow: hidden;
    }

    h1 {
        margin-bottom: 20px; /* h1 태그의 하단 마진 조정 */
    }

    .tech-detail {
        width: 1000px;
        max-height: 800px;
    }

    .title {
        white-space: normal;
        overflow: visible;
        font-size: 18px;
        vertical-align: middle;
    }
</style>
