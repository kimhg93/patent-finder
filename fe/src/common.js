import emitter from '@/components/event-bus';

export default {
    install(Vue) {

        // [getSum 함수 설정]
        Vue.config.globalProperties.$showAlert = (msg, type) => {
            emitter.emit('show-alert', { message: msg, type: type });
        };
        Vue.config.globalProperties.$showStatus = (appNo) => {
            let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=1000, height=1000, top=0,left=0";
            window.open(`http://kibc24.com/search/search.php?mode=realtime&linkNumber=${appNo}`, "_blank", options);
        };
        Vue.config.globalProperties.$loadItems = (page, itemsPerPage, func) => {
            this.currentPage = page;
            this.itemsPerPage = itemsPerPage;
            func();
        };
    }
}