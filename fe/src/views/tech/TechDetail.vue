<template>
    <div class="container ">
        <v-card :height="cardHeight" class="bg-color">
        <div class="radio-container">
            <v-radio-group inline v-model="searchType">
                <v-radio color="primary" value="detail" class="radio">
                    <template v-slot:label>
                        <span class="radio-label">클래스+그룹으로보기 (예: H04B 2/00)</span>
                    </template>
                </v-radio>

                <v-radio color="success" value="range" class="radio">
                    <template v-slot:label>
                        <span class="radio-label">클래스로 보기 (예: H04B)</span>
                    </template>
                </v-radio>
            </v-radio-group>
        </div>

        <h1>{{title}}</h1>

        <div class="tech-detail bg-color" style="margin:auto">
            <v-app id="inspire" class="bg-color">
                <v-main>
                    <v-container>
                        <v-row>
                            <v-col v-for="(item, index) in items" :key="item.techItemNo" cols="12" sm="6" md="4">
                                <v-card height="130" @click="goTo(`/main/${this.searchType}/${item.techFieldNo}/${item.techItemNo}`)" class="card">
                                    <v-card-title class="title">{{ index+1 }}. {{ item.techItemNm }}</v-card-title>
                                </v-card>
                            </v-col>
                        </v-row>
                    </v-container>
                </v-main>
            </v-app>
        </div>
    </v-card>
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
                searchType: "",
            };

        },
        computed: {
            cardHeight() {
                let height = 200;
                let length = this.items.length;

                if(length%3 === 0) height += parseInt(length/3) * 170;
                else height += parseInt(length/3+1) * 170;

                return `${height}px`;
            }
        },
        created() {
            this.fetchItemData();
        },
        methods: {
            goTo(link) {
                if(this.searchType == "") {
                    this.$showAlert("검색조건이 선택되지 않았습니다. 검색 조건을 선택해 주세요.", "warning");
                    return;
                }
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
    .radio-container {
        margin: 40px auto;
        width:640px
    }
    .radio {
        margin: 0px 20px;
    }
    .radio-label {
        font-size: 18px;
        color: black;
        font-weight: bold;
    }
    .card {
    }
    .back-ground {
        width:1200px;
        margin: 30px auto;
    }
    .bg-color {
        background-color: #E0E9F0;
    }
    .radio-label {
        letter-spacing: -.7px;
    }
</style>
