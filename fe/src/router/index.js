import { createRouter, createWebHistory } from 'vue-router'
import Tech from '@/views/tech/Tech.vue'
import TechDetail from '@/views/tech/TechDetail.vue'
import TechGrid from '@/views/tech/TechGrid.vue'
import TechEtc from '@/views/tech/TechEtc.vue'
import AppNumberSearch from '@/views/ipc/AppNumberSearch.vue'
import FinderSearch from '@/views/user/FinderSearch.vue'
import SellerSearch from '@/views/user/SellerSearch.vue'
import FinderDetailUniv from '@/views/user/FinderDetailUniv.vue'
import FinderDetailComp from '@/views/user/FinderDetailComp.vue'


const routes = [
    { path: '/', name: 'IndexPage', component: Tech },
    { path: '/tech', alias: '/', name: 'TechIndex', component: Tech }, // 인덱스(기술분류)
    { path: '/tech/etc', name: 'TechEtc', component: TechEtc }, // 기타 기술 분류 검색
    { path: '/tech/:code', name: 'TechDetail', component: TechDetail, props: true }, // 기술분류 검색 detail
    { path: '/:source(main|etc)/:searchType/:techFieldNo/:techItemNo', name: 'TechGrid', component: TechGrid, props: true }, // 기술분류상세
    { path: '/number', name: 'AppNumberSearch', component: AppNumberSearch, props: true }, // 출원번호검색
    { path: '/finder', name: 'FinderSearch', component: FinderSearch, props: true }, // 대학/연구소
    { path: '/seller', name: 'SellerSearch', component: SellerSearch, props: true }, // 중소기업
    { path: '/univ/:searchType/:ipc', name: 'FinderDetailUniv', component: FinderDetailUniv, props: true }, // 중소기업 > 대학/연구소
    { path: '/comp/:searchType/:ipc', name: 'FinderDetailComp', component: FinderDetailComp, props: true }, // 중소기업 > 경쟁업체
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router