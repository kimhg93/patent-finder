UserSearch.vue<template>
    <div class="container">
        <v-card class="mx-auto" color="grey-lighten-3" max-width="95%">
            <v-card-text>
                <v-row no-gutters>
                    <v-col cols="12" md="2" lg="2" v-if="changeUi">
                        <v-text-field
                                :loading="loading"
                                density="compact"
                                variant="solo"
                                label="ID"
                                hide-details
                                v-model="id"
                                prepend-inner-icon="mdi-account">
                        </v-text-field>
                    </v-col>
                    <v-col cols="12" md="2" lg="2" v-if="changeUi">
                        <v-text-field
                                :loading="loading"
                                density="compact"
                                variant="solo"
                                label="Password"
                                type="password"
                                prepend-inner-icon="mdi-lock-outline"
                                hide-details
                                v-model="password">
                        </v-text-field>
                    </v-col>
                    <v-col cols="12" md="1" lg="1" align-self="center" class="col-btn-search" v-if="changeUi">
                        <v-btn @click="searchClick()" >검색</v-btn>
                    </v-col>

                    <!-- 조회 후 영역 -->
                    <v-col cols="12" md="3" lg="3" v-if="!changeUi">
                        <div class="orgTitle"><h3>{{orgTitle}}</h3></div>
                    </v-col>
                    <v-col cols="12" md="1" lg="1" align-self="center" class="col-btn-search" v-if="!changeUi">
                        <v-btn @click="searchClick()" >수정내용저장</v-btn>
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
                        <td class="grid-td">{{ item.regNo }}</td>
                        <td class="grid-td">{{ item.regDate }}</td>
                        <td class="grid-td">{{ item.appNo }}</td>
                        <td class="grid-td">{{ item.appDate }}</td>
                        <td class="grid-td">{{ item.appNm }}</td>
                        <td class="grid-td"> <v-checkbox-btn class="tb-checkbox"></v-checkbox-btn></td>
                        <td class="grid-td text-left" :title="item.invTitle">{{ item.invTitle }}</td>
                        <td class="grid-td">
                            <v-btn class="btn-status" @click="this.$showStatus(item.appNo)">현재상태보기<br></v-btn>
                        </td>
                        <td class="grid-td"><input type="text" class="tb-input" ></td>
                        <td class="grid-td"><input type="text" class="tb-input" ></td>
                    </tr>
                </template>

            </v-data-table-server>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "SellerSearch",
        props: [],
        data() {
            return {
                loading: true,
                itemsPerPage: 30,
                currentPage: 1,
                totalCount: 0,
                techFieldNo: 0,
                techItemNo: 0,
                id: "",
                password: "",
                changeUi: true,
                orgTitle: "",
                headers: [
                    { width:"100",title: '등록번호', align: 'center', sortable: false, key: 'regNo' },
                    { width:"80",title: '등록일자', align: 'center', key: 'regDate' },
                    { width:"100",title: '출원번호', align: 'center', key: 'appNo' },
                    { width:"80",title: '출원일자', align: 'center', key: 'appDate' },
                    { width:"120",title: '권리자', align: 'center', key: 'appNm' },
                    { width:"90",title: '판매여부', align: 'center', key: 'conDate' },
                    { width:"200",title: '발명의 명칭', align: 'center', key: 'invTitle' },
                    { width:"90",title: '현재상태', align: 'center', key: 'status' },
                    { width:"80",title: '예상가격', align: 'center', key: 'estPrice' },
                    { width:"90",title: '연락처', align: 'center', key: 'contactNum' },
                ],
                list: [],
            };
        },
        methods: {
            async fetchData() {
                this.loading = true;
                try {
                    const url = `/api/seller/data`;

                    const response = await axios.get(url, {
                        params: {
                            id: this.id,
                            password: this.password,
                            page: this.currentPage,
                            size: this.itemsPerPage,
                        },
                    });

                    this.list = response.data.list;
                    this.totalCount = response.data.totalCount;
                    if(isNaN(this.totalCount)) this.totalCount = 0;

                    if(this.totalCount > 0) {
                        this.changeUi = false;
                        this.orgTitle = this.list[0].appNm;
                    }
                } catch (e) {
                    console.error(e);
                } finally {
                    this.loading = false;
                }
            },

            searchClick() {
                if(this.id == "" || this.password == ""){
                    this.$showAlert("아이디 또는 비밀번호를 확인하세요.", "warning");
                    return;
                }
                if(this.searchType == "") {
                    this.$showAlert("검색조건이 선택되지 않았습니다. 검색 조건을 선택해 주세요.", "warning");
                    return;
                }
                this.fetchData();
            },
            loadItems({page, itemsPerPage}) {
                this.currentPage = page;
                this.itemsPerPage = itemsPerPage;
                this.fetchData();
            },
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

    .tb-input {
        border: 1px solid #c5c5c5;
        width: 95%;
        margin: 0;
        padding: 0;
        height: 30px;
        text-align: center;
        font-size: 13px;
    }
    .tb-checkbox{
        height:30px;
        width: 45px;
        margin: auto;
    }
    .orgTitle {
        margin-top:10px;
        margin-left: 20px;
    }
</style>
