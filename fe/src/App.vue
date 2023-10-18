<template>
  <v-app>
    <Header/>

    <v-main>
      <v-container fluid>
        <Alert/>
        <router-view/>
      </v-container>
    </v-main>

    <Footer/>
  </v-app>
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'
import Alert from './components/CommonAlert.vue'

export default {
  name: 'App',

  components: {
    Header,
    Footer,
    Alert,
  },

  data: () => ({

  }),
}
</script>
