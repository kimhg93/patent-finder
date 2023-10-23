<template>
    <header>
        <v-navigation-drawer app elevation="2" v-model="drawer">
            <v-list :items="items">
                <v-list-item v-for="item in items" :title="item.title" :key="item.title" @click="navigate(item)">
                </v-list-item>
            </v-list>
        </v-navigation-drawer>

        <v-app-bar elevation="2" flat>
            <v-btn icon @click="drawer = !drawer">
                <v-icon>mdi-menu</v-icon>
            </v-btn>
        </v-app-bar>
    </header>
</template>

<script>
    export default {
        name: "PageHeader",

        components: {
        },

        data: () => ({
            drawer: true,
            items: [
                //{ title: 'Home', path: '/' },
                //{ title: 'About', path: '/about' },
                { title: '회원 로그인', path: '/finder' },
                { title: '판매자 로그인', path: '/seller' },
                { title: '기술분류 검색', path: '/tech' },
                { title: '기타 기술분류 검색', path: '/tech/etc' },
                { title: '출원번호 검색', path: '/number' },
            ],
        }),
        methods: {
            navigate(item) {
                this.$router.push(item.path);
            },
        },
    }
</script>

<style scoped>

</style>
