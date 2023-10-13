import { createRouter, createWebHistory } from 'vue-router'
import Tech from '@/views/tech/Tech.vue'
import TechDetail from '@/views/tech/TechDetail.vue'
import TechGrid from '@/views/tech/TechGrid.vue'
import TechEtc from '@/views/tech/TechEtc.vue'


const routes = [
    { path: '/', name: 'TechIndex', component: Tech },
    { path: '/tech', name: 'TechIndex', component: Tech }, // 기술분류 검색 1page
    { path: '/tech/:code', name: 'TechDetail', component: TechDetail, props: true }, // 기술분류 검색 2page
    { path: '/tech/:code/:codeDetail', name: 'TechGrid', component: TechGrid, props: true }, // 기술분류 검색 grid
    { path: '/tech/etc', name: 'TechEtc', component: TechEtc }, // 기타 기술 분류 검색

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router