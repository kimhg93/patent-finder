import { createRouter, createWebHistory } from 'vue-router'
import Tech from '@/views/tech/Tech.vue'
import TechDetail from '@/views/tech/TechDetail.vue'
import TechGrid from '@/views/tech/TechGrid.vue'
import TechEtc from '@/views/tech/TechEtc.vue'
import AppNumberSearch from '@/views/ipc/AppNumberSearch.vue'


const routes = [
    { path: '/', name: 'IndexPage', component: Tech },
    { path: '/tech', name: 'TechIndex', component: Tech }, // 기술분류 검색 1page
    { path: '/tech/:code', name: 'TechDetail', component: TechDetail, props: true }, // 기술분류 검색 2page
    { path: '/tech/etc', name: 'TechEtc', component: TechEtc }, // 기타 기술 분류 검색
    { path: '/:source/:searchType/:techFieldNo/:techItemNo', name: 'TechGrid', component: TechGrid, props: true }, // grid
    { path: '/number', name: 'AppNumberSearch', component: AppNumberSearch, props: true }, // grid

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router