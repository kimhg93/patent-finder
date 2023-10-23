<template>
    <div class="container">
        <div class="radio-container">
            <v-radio-group inline v-model="searchType">
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
        </div>
        <v-table :hover="false" class="elevation-1" > <!-- 전체 테이블에 대한 hover를 비활성화 -->
            <thead>
            <tr>
                <th class="text-center table-header border-sm header-color" >기타 기술 분야1</th>
                <th class="text-center table-header border-sm header-color">기타 기술 분야2</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(item, index) in combinedItems" :key="index">
                <td @click="goTo(item.ETC1Link)" class="hoverable grid-td border-sm bg-color" width="500">
                    {{ item.ETC1 }}
                </td>
                <td @click="goTo(item.ETC2Link)" class="hoverable grid-td border-sm bg-color" width="500">
                    {{ item.ETC2 }}
                </td>
            </tr>
            </tbody>
        </v-table>
    </div>
</template>



<script>
    import axios from "axios";

    export default {
        name: "TechEtc",
        data() {
            return {
                techFields: [], // 데이터를 저장할 배열
                combinedItems: [],
                searchType: "",
            }
        },
        created() {
            this.fetchItemData();
        },
        methods: {
            async fetchItemData() {
                try {
                    const response = await axios.get(`/api/tech/etc`);
                    this.techFields = response.data; // 응답 데이터를 techFields에 저장
                    this.combineItems();
                } catch (e) {
                    console.error(e);
                }
            },
            combineItems() {
                const itemsETC1 = this.techFields.filter(item => item.techFieldType == "ETC1");
                const itemsETC2 = this.techFields.filter(item => item.techFieldType == "ETC2");

                const maxLength = Math.max(itemsETC1.length, itemsETC2.length);

                for (let i = 0; i < maxLength; i++) {
                    const itemETC1 = itemsETC1[i] ? { name: itemsETC1[i].techFieldNm, link: `${itemsETC1[i].techFieldNo}/${itemsETC1[i].techItemNo}` /* ETC1 링크 생성 로직 */ } : { name: "", link: "#" };
                    const itemETC2 = itemsETC2[i] ? { name: itemsETC2[i].techFieldNm, link: `${itemsETC2[i].techFieldNo}/${itemsETC2[i].techItemNo}` /* ETC2 링크 생성 로직 */ } : { name: "", link: "#" };

                    this.combinedItems.push({
                        ETC1: itemETC1.name,
                        ETC1Link: itemETC1.link,
                        ETC2: itemETC2.name,
                        ETC2Link: itemETC2.link
                    });
                }
            },
            goTo(link) {
                if(this.searchType == "") {
                    this.$showAlert("검색조건이 선택되지 않았습니다. 검색 조건을 선택해 주세요.", "warning");
                    return;
                }
                window.location.href = `/etc/${this.searchType}/${link}`;
            },
        },
    };
</script>


<style scoped>
    .container {
        max-width: 1200px;
        margin: auto;
    }
    .table-header {
        font-size: 20px;
        font-weight: 900;
    }
    .hoverable {
        cursor: pointer;
    }
    .hoverable:hover {
        background-color: lightgray;
    }
    .grid-td {
        height: 45px !important;
    }
    .radio-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 20px auto;
        width: 700px;
    }
    .radio {
        margin: 0px 20px;
    }
    .radio-label {
        font-size: 18px;
        color: black;
        font-weight: bold;
    }
    .bg-color {
        background-color: #E0E9F0;
    }
    .header-color {
        background-color: #71838F;
        color: #ffffff !important;
        font-weight: bold !important;
    }
</style>
