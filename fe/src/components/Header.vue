<template>
    <header v-if="showHeader">
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
            <v-spacer></v-spacer>
            <h2>{{ title }}</h2>
            <v-spacer></v-spacer>
        </v-app-bar>
    </header>
</template>

<script>
    export default {
        name: "PageHeader",

        components: {
        },

        data: () => ({
            items: [
                //{ title: 'Home', path: '/' },
                //{ title: 'About', path: '/about' },
                { title: '회원 서비스', path: '/finder' },
                { title: '판매자 서비스', path: '/seller' },
                { title: '기술분류 검색', path: '/tech' },
                { title: '기타 기술분류 검색', path: '/tech/etc' },
                { title: '출원번호 검색 서비스', path: '/number' },
                { title: '출원인 검색 서비스', path: '/name' },
            ],
        }),
        computed: {
            drawer() {
                if(this.$route.meta.drawer != false) return true;
                else return this.$route.meta.drawer;
            },
            title() {
                const url = this.$route.path;
                if(url.indexOf("/etc/detail/") == 0) return "기타 기술분류 검색";
                if(url == "/") return "";

                return this.$route.meta.title;
            },
            showHeader() {
                return this.$route.path != "/";
            }
        },
        methods: {
            navigate(item) {
                this.$router.push(item.path);
            },
        },
        created() {
        }
    }
</script>

<style scoped>

</style>
