<template>
    <div class="tech">
        <div class="centered-container">
            <v-app id="inspire">
                <v-main>
                    <v-container>
                        <v-row justify="space-between">
                            <v-col v-for="(group, techGroupNo, index) in groupedData" :key="techGroupNo" cols="4">
                                <v-card :class="[{ 'even-card': index % 2 === 0, 'odd-card': index % 2 !== 0 }
                                                , index < 3 ? 'parent-first-row' : 'parent-second-row']"
                                        class="parent-card mb-5" width="400">
                                    <v-card-title class="parent-title">{{ group[0].techGroupNo }}. {{group[0].techGroupNm}} ({{group.length}})</v-card-title>
                                    <v-row justify="space-between" class="child-row pa-4">
                                        <v-col v-for="item in group" :key="item.techFieldNo" cols="6" class="child-col">
                                            <v-card class="child-card" width="100%" height="75" @click="goTo(item.url)">
                                                <v-card-title class="child-title">{{ item.techFieldNm }}</v-card-title>
                                            </v-card>
                                        </v-col>
                                    </v-row>
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
        name: "TechIndex",
        data() {
            return {
                items: [],
            };
        },
        created() {
            this.fetchData();
        },
        methods: {
            async fetchData() {
                try {
                    const response = await axios.get('/api/tech');
                    this.items = response.data;
                } catch (e) {
                    console.error(e);
                }
            },
            goTo(link) {
                window.location.href = link;
            }
        },
        computed: {
            groupedData() {
                return this.items.reduce((acc, item) => {
                    if (!acc[item.techGroupNo]) {
                        acc[item.techGroupNo] = [];
                    }
                    acc[item.techGroupNo].push(item);
                    return acc;
                }, {});
            },
        }
    }
</script>


<style scoped>
    .centered-container {
        width: 100%;
        max-height: 920px
    }
    .tech {
        width: 1300px;
        display: flex;
        overflow: hidden;
        margin: auto;
    }
    .parent-title {
        font-size: 20px;
        margin-bottom: 1rem;
        color: #ffffff;
        font-weight: bold;
    }
    .parent-card {
        margin-bottom: 3rem;
        height: 100%;
    }
    .child-card {
        margin-bottom: 1rem;
        background-color: #F2F2F2;
    }

    .child-col {
        text-align: center;
        padding: 0 10px;
    }
    .child-title {
        white-space: normal;
        overflow: visible;
        font-size: 16px;
        vertical-align: middle;
    }
    .parent-first-row {
        height: 338px;
    }
    .parent-second-row {
        height: 520px;
    }
    .even-card {
        background-color: #b2bec5; /* 원하는 색상 코드로 교체 */
    }
    .odd-card {
        background-color: #71838F; /* 원하는 색상 코드로 교체 */
    }
</style>
