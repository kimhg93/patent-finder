UserSearch.vue<template>
    <div class="container">
        <v-card
                class="mx-auto"
                color="grey-lighten-3"
                max-width="95%">
            <v-card-text>
                <v-row no-gutters>
                    <!-- Text Field Column -->
                    <v-col cols="12" md="2" lg="2">
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
                    <v-col cols="12" md="2" lg="2">
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


                    <!-- Radio Group Column -->
                    <v-col cols="12" md="4" lg="4">
                        <v-radio-group inline class="rdo-grp" hide-details align-self="center" v-model="searchType">
                            <v-radio color="primary" value="detail" class="radio">
                                <template v-slot:label>
                                    <span class="radio-label">그룹으로 보기(상세 검색 가능)</span>
                                </template>
                            </v-radio>

                            <v-radio color="success" value="range" class="radio">
                                <template v-slot:label>
                                    <span class="radio-label">클래스로 보기(광범위 검색)</span>
                                </template>
                            </v-radio>
                        </v-radio-group>
                    </v-col>
                    <v-col cols="12" md="1" lg="1" align-self="center" class="btn-search" >
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
                        <td class="grid-td text-center">{{ item.regNo }}</td>
                        <td class="grid-td text-center">{{ item.regDate }}</td>
                        <td class="grid-td text-center">{{ item.appNo }}</td>
                        <td class="grid-td text-center">{{ item.appDate }}</td>
                        <td class="grid-td text-center">{{ item.appNm }}</td>
                        <td class="grid-td text-center" :title="item.conDate">{{ item.conDate }}</td>
                        <td class="grid-td text-left" :title="item.invTitle">{{ item.invTitle }}</td>
                        <td class="grid-td text-center">
                            <v-btn class="btn-status" @click="showStatus(item.appNo)">현재상태보기<br></v-btn>
                        </td>
                        <td class="grid-td text-center">{{ item.ipc }}</td>
                        <td class="grid-td text-center">
                            <v-btn class="btn-status" @click="showDetail(item.ipc, 2)">선택<br></v-btn>
                        </td>
                        <td class="grid-td">
                            <v-btn class="btn-status" @click="showDetail(item.ipc, 3)">선택<br></v-btn>
                        </td>
                    </tr>
                </template>

            </v-data-table-server>
        </div>
    </div>
</template>

<script>
    import axios from "axios";
    import emitter from '@/components/event-bus';

    export default {
        name: "FinderSearch",
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
                id: "",
                password: "",
                headers: [
                    { width:"100",title: '등록번호', align: 'center', sortable: false, key: 'regNo' },
                    { width:"80",title: '등록일자', align: 'center', key: 'regDate' },
                    { width:"100",title: '출원번호', align: 'center', key: 'appNo' },
                    { width:"80",title: '출원일자', align: 'center', key: 'appDate' },
                    { width:"120",title: '권리자', align: 'center', key: 'appNm' },
                    { width:"70",title: '존속일', align: 'center', key: 'conDate' },
                    { width:"200",title: '발명의 명칭', align: 'center', key: 'invTitle' },
                    { width:"90",title: '현재상태', align: 'center', key: 'status' },
                    { width:"50",title: 'IPC', align: 'center', key: 'ipc' },
                    { width:"100",title: '대학/연구소', align: 'center', key: 'univ' },
                    { width:"80",title: '경쟁업체', align: 'center', key: 'comp' },
                ],
                list: [],
            };
        },
        methods: {
            async fetchData() {
                this.loading = true;
                try {
                    const url = `/api/finder/data`;

                    const response = await axios.get(url, {
                        params: {
                            id: this.id,
                            password: this.password,
                            searchType: this.searchType,
                            page: this.currentPage,
                            size: this.itemsPerPage,
                        },
                    });

                    this.list = response.data.list;
                    this.totalCount = response.data.totalCount;
                } catch (e) {
                    console.error(e);
                } finally {
                    this.loading = false;
                }
            },

            loadItems({page, itemsPerPage, sortBy}) {
                this.currentPage = page;
                this.itemsPerPage = itemsPerPage;
                console.log(sortBy);
                this.fetchData();
            },
            showStatus(appNo) {
                let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=1000, height=1000, top=0,left=0";
                window.open(`http://kibc24.com/search/search.php?mode=realtime&linkNumber=${appNo}`, "_blank", options);
            },
            showDetail(ipc, buttonType){
                if(buttonType == 2){
                    location.href = `/finder/univ/${this.searchType}/${encodeURIComponent(ipc)}`;
                } else {
                    location.href = `/finder/comp/${this.searchType}/${encodeURIComponent(ipc)}`;
                }

            },
            searchClick() {
                if(this.id == "" || this.password == ""){
                    emitter.emit('show-alert', { message: "아이디 또는 비밀번호를 확인하세요.", type: "warning" });
                    return;
                }
                if(this.searchType == "") {
                    emitter.emit('show-alert', { message: "검색조건이 선택되지 않았습니다. 검색 조건을 선택해 주세요.", type: "warning" });
                    return;
                }
                this.fetchData();
            },

        },
        created() {
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
    .btn-search > button {
        margin-left: 10px;
    }
</style>
