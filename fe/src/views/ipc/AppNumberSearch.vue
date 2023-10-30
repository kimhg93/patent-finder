<template>
    <div class="container">
        <v-card class="mx-auto" color="grey-lighten-3" max-width="95%">
            <v-card-text>
                <v-row no-gutters>
                    <v-col cols="12" md="3" lg="3">
                        <v-text-field
                                :loading="loading"
                                density="compact"
                                variant="solo"
                                label="출원번호"
                                append-inner-icon="mdi-magnify"
                                hide-details
                                v-model="appNumber"
                                @click:append-inner="searchClick">
                        </v-text-field>
                    </v-col>
                    <v-col cols="12" md="4" lg="4" v-if="radioDisplay">
                        <v-radio-group inline class="rdo-grp" hide-details align-self="center" v-model="searchType">
                            <v-radio color="primary" value="detail" class="radio" @click="radioChange('detail')">
                                <template v-slot:label>
                                    <span class="radio-label">클래스+그룹으로보기 (예: H04B 2/00)</span>
                                </template>
                            </v-radio>
                            <v-radio color="success" value="range" class="radio" @click="radioChange('range')">
                                <template v-slot:label>
                                    <span class="radio-label">클래스로 보기 (예: H04B)</span>
                                </template>
                            </v-radio>
                        </v-radio-group>
                    </v-col>
                    <v-col cols="12" md="1" lg="1" align-self="center" class="col-btn-search" >
                        <v-btn @click="searchClick()">검색</v-btn>
                    </v-col>
                </v-row>
            </v-card-text>
        </v-card>
        <div class="grid-container">
            <v-data-table-server
                    class="elevation-1"
                    :headers="headers"
                    :items="list"
                    :page="currentPage"
                    :loading="loading"
                    :items-per-page="itemsPerPage"
                    :items-length="totalCount"
                    :height="700"
                    :row-height="100"
                    item-key="title"
                    @update:options="loadItems">

                <template v-slot:item="{ item }">
                    <tr class="grid-tr">
                        <td class="grid-td">{{ item.appNo }}</td>
                        <td class="grid-td">{{ item.appDate }}</td>
                        <td class="grid-td text-left" :title="item.invTitle">{{ item.invTitle }}</td>
                        <td class="grid-td text-left" :title="item.appNm">{{ item.appNm }}</td>
                        <td class="grid-td">{{ item.regNo }}</td>
                        <td class="grid-td">{{ item.regDate }}</td>
                        <td class="grid-td">
                            <v-btn class="btn-status" @click="this.$showStatus(item.appNo)">현재상태보기<br></v-btn>
                        </td>
                        <td class="grid-td">{{ item.estPrice }}</td>
                        <td class="grid-td">{{ item.contactNum }}</td>
                    </tr>
                </template>

            </v-data-table-server>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "TechGrid",
        props: [],
        data() {
            return {
                loading: true,
                itemsPerPage: 30,
                currentPage: 1,
                totalCount: 0,
                techFieldNo: 0,
                techItemNo: 0,
                searchType: "",
                appNumber: "",
                radioDisplay: false,
                lastSelected: null,
                headers: [
                    { width:"90",title: '출원번호', align: 'center', sortable: false, key: 'appNo' },
                    { width:"70",title: '출원일자', align: 'center', key: 'appDate' },
                    { width:"220",title: '발명의명칭', align: 'center', key: 'invTitle' },
                    { width:"210",title: '출원인', align: 'center', key: 'appNm' },
                    { width:"90",title: '등록번호', align: 'center', key: 'regNo' },
                    { width:"70",title: '등록일자', align: 'center', key: 'regDate' },
                    { width:"80",title: '현재상태', align: 'center', key: 'compCode' },
                    { width:"70",title: '예상가격', align: 'center', key: 'estPrice' },
                    { width:"70",title: '연락처', align: 'center', key: 'contactNum' },
                ],
                list: [],
            };
        },
        methods: {
            async fetchData() {
                this.loading = true;
                try {
                    const url = `/api/data/number/${this.appNumber}`;

                    const response = await axios.get(url, {
                        params: {
                            searchType: this.searchType,
                            page: this.currentPage,
                            size: this.itemsPerPage,
                        },
                    });
                    this.list = response.data.list;
                    this.totalCount = response.data.totalCount;
                    if(isNaN(this.totalCount)) this.totalCount = 0;
                    if(this.totalCount > 0) {
                        this.radioDisplay = true;
                        if(this.searchType == "") this.searchType = "detail";
                    }
                } catch (e) {
                    console.error(e);
                } finally {
                    this.loading = false;
                }
            },

            searchClick() {
                this.fetchData();
            },

            loadItems({page, itemsPerPage}) {
                this.currentPage = page;
                this.itemsPerPage = itemsPerPage;
                this.fetchData();
            },

            radioChange(value) {
                if (this.searchType === value) {
                    this.$nextTick(() => {
                        this.searchType = null;
                    });
                }
            }

        },
    };
</script>

<style scoped>
    .container {
        max-height: 900px;
        margin-top: 10px;
    }
    .grid-container{
        max-width:95%;
        margin: 30px auto;
        max-height: 900px;
    }
    :deep(.v-data-table__th) {
        background-color: #949494 !important;
        height: 45px !important;
        font-size: 14px !important;
    }
    :deep(.v-data-table-header__content) {
        color: white;
        font-weight: 600;
    }
    .grid-td {
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis !important;
        max-width: 1px;
        font-size: 12px;
        text-align: center;
        height: calc(var(--v-table-row-height, 35px) + 0px) !important;
    }
    .btn-status {
        height: 30px;
    }
    .btn-status > :deep(.v-btn__content) {
        font-size: 12px;
    }
    .rdo-grp {
        margin-top: 5px;
    }
    .col-btn-search > button {
        margin-left: 10px;
        background-color: #71838F;
        color: #ffffff;
        font-weight: bold;
    }
    .radio-label {
        letter-spacing: -.7px;
    }
</style>