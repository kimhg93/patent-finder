<template>
    <div class="container">
        <v-table :hover="false" > <!-- 전체 테이블에 대한 hover를 비활성화 -->
            <thead>
            <tr>
                <th class="text-center table-header">기타 기술 분야1</th>
                <th class="text-center">기타 기술 분야2</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(item, index) in combinedItems" :key="index">
                <td @click="goToLink(item.ETC1Link)" class="hoverable">
                    {{ item.ETC1 }}
                </td>
                <td @click="goToLink(item.ETC2Link)" class="hoverable">
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
                headers: [
                    { text: 'ETC1', value: 'techFieldNo' },
                    { text: 'ETC2', value: 'techFieldNm' },
                ],
                techFields: [
                ],
                combinedItems: [],
            }
        },
        created() {
            this.fetchItemData();
        },
        methods: {
            async fetchItemData() {
                try {
                    const response = await axios.get(`/api/tech/etc`);
                    this.items = response.data;
                    this.combineItems();
                } catch (e) {
                    console.error(e);
                }
            },
            combineItems() {
                const itemsETC1 = this.techFields.filter(item => item.techFieldType === "ETC1");
                const itemsETC2 = this.techFields.filter(item => item.techFieldType === "ETC2");

                // ETC1과 ETC2의 길이 중 더 긴 것을 기준으로 합니다.
                const maxLength = Math.max(itemsETC1.length, itemsETC2.length);

                for (let i = 0; i < maxLength; i++) {
                    // 항목이 없는 경우를 위해 빈 문자열을 기본값으로 사용합니다.
                    const itemETC1 = itemsETC1[i] ? itemsETC1[i].techFieldNm : "";
                    const itemETC2 = itemsETC2[i] ? itemsETC2[i].techFieldNm : "";

                    this.combinedItems.push({ ETC1: itemETC1, ETC2: itemETC2 });
                }
            },
            goToLink(link) {
                window.location.href = link; // 이 부분은 실제 링크 구조에 따라 변경해야 합니다.
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
        cursor: pointer; /* 마우스 커서를 손가락 모양으로 변경 */
    }
    .hoverable:hover {
        background-color: lightgray; /* 원하는 hover 효과 색상으로 변경 */
    }
</style>
