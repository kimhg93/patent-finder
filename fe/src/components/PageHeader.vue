<template>
    <header>
        <v-navigation-drawer app elevation="2" v-model="drawer">
            <v-list>
                <v-list-item-group>
                    <v-list-item v-for="item in items" :key="item.title" @click="navigate(item)">
                        <v-list-item-content>
                            <v-list-item-title>{{ item.title }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-item-group>
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
            drawer: false,
            items: [
                { title: 'Home', path: '/' },
                { title: 'About', path: '/about' },
                // Add more navigation items as needed
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