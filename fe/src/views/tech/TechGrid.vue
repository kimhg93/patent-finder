<template>
    <div class="container">
        <div class="grid-container">
            <v-data-table class="elevation-1"
                          v-model:items-per-page="itemsPerPage"
                          :headers="headers"
                          :items="list"
                          :hover="true"
                          :height="700"
                          :row-height=100
                          item-key="title">

                <template v-slot:item="{ item }">
                    <tr class="grid-tr">
                        <td class="grid-td">{{ item.number }}</td>
                        <td class="grid-td">{{ item.date }}</td>
                        <td class="grid-td" :title="item.title">{{ item.title }}</td>
                        <td class="grid-td" :title="item.name">{{ item.name }}</td>
                        <td class="grid-td">{{ item.regNum }}</td>
                        <td class="grid-td">{{ item.regDate }}</td>
                        <td class="grid-td"><v-btn class="btn-status">현재상태보기<br></v-btn></td>
                        <td class="grid-td">{{ item.price }}</td>
                        <td class="grid-td">{{ item.phone }}</td>
                    </tr>
                </template>
            </v-data-table>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "TechGrid",
        props: ["code", "codeDetail"],
        methods: {
            async fetchData() {
                try {
                    const response = await axios.get('/api/tech/1/5');
                    this.list = response.data;
                } catch (e) {
                    console.error(e);
                }
            },
        },
        created() {
            this.fetchData();
        },
        data() {
            return {
                itemsPerPage: 50,
                headers: [
                    { width:"90",title: '출원번호', align: 'center', sortable: false, key: 'number' },
                    { width:"70",title: '출원일자', align: 'center', key: 'date' },
                    { width:"220",title: '발명의명칭', align: 'center', key: 'title' },
                    { width:"210",title: '출원인', align: 'center', key: 'name' },
                    { width:"90",title: '등록번호', align: 'center', key: 'regNum' },
                    { width:"70",title: '등록일자', align: 'center', key: 'regDate' },
                    { width:"80",title: '현재상태', align: 'center', key: 'compCode' },
                    { width:"70",title: '예상가격', align: 'center', key: 'price' },
                    { width:"70",title: '연락처', align: 'center', key: 'phone' },
                ],
                list: [],
            }
        },
    }
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