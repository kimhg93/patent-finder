<template>
    <div class="container">
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
        props: ["source", "searchType", "techFieldNo", "techItemNo"],
        data() {
            return {
                loading: true,
                itemsPerPage: 30,
                currentPage: 1,
                totalCount: 0,
                headers: [
                    { width:"100",title: '출원번호', align: 'center', sortable: false, key: 'appNo' },
                    { width:"80",title: '출원일자', align: 'center', key: 'appDate' },
                    { width:"230",title: '발명의명칭', align: 'center', key: 'invTitle' },
                    { width:"150",title: '출원인', align: 'center', key: 'appNm' },
                    { width:"100",title: '등록번호', align: 'center', key: 'regNo' },
                    { width:"80",title: '등록일자', align: 'center', key: 'regDate' },
                    { width:"80",title: '현재상태', align: 'center', key: 'compCode' },
                    { width:"80",title: '예상가격', align: 'center', key: 'estPrice' },
                    { width:"70",title: '연락처', align: 'center', key: 'contactNum' },
                ],
                list: [],
            };
        },
        methods: {
            async fetchData() {
                this.loading = true;
                try {
                    const url = `/api/data/tech/${this.techFieldNo}/${this.techItemNo}`;

                    const response = await axios.get(url, {
                        params: {
                            searchType: this.searchType,
                            source: this.source,
                            page: this.currentPage,
                            size: this.itemsPerPage,
                        },
                    });

                    this.list = response.data.list;
                    this.totalCount = response.data.totalCount;
                    if(isNaN(this.totalCount)) this.totalCount = 0;
                } catch (e) {
                    console.error(e);
                } finally {
                    this.loading = false;
                }
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
    }
    .grid-container{
        max-width:95%;
        margin: 50px auto;
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
</style>
