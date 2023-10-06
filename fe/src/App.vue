<template>
  <v-app>
    <PageHeader/>

    <v-main>
      <v-container fluid>
        <router-view/>
      </v-container>
    </v-main>

    <PageFooter/>
  </v-app>
</template>

<script>
import PageHeader from './components/PageHeader.vue'
import PageFooter from './components/PageFooter.vue'

export default {
  name: 'App',

  components: {
    PageHeader,
    PageFooter
  },

  data: () => ({

  }),
}
</script>
