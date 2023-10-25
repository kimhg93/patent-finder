<template>
  <v-app>
    <Header/>

    <v-main>
      <v-container fluid>
        <Alert/>
        <router-view/>
      </v-container>
    </v-main>

  </v-app>
</template>

<script>
import Header from './components/Header.vue'
import Alert from './components/CommonAlert.vue'

export default {
  name: 'App',

  components: {
    Header,
    Alert,
  },

  data: () => ({

  }),
}
</script>
