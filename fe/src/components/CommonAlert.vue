<template>
        <div>
            <!-- Vue의 <transition> 컴포넌트를 사용하여 fade 효과 구현 -->
            <transition name="fade">
                <v-alert transition="fade-transition" v-if="alert.message" :type="alert.type" dismissible closable="true">
                    {{ alert.message }}
                </v-alert>
            </transition>
        </div>

</template>

<script>
    import emitter from './event-bus';

    export default {
        name: "CommonAlert",

        components: {
        },

        data: () => ({
            alert: {
                message: '',
                type: '' // 기본값, 'error', 'warning', 'info', 'success' 중 하나를 사용할 수 있습니다.
            },
        }),
        mounted() {
            emitter.on('show-alert', this.showAlert);
        },
        beforeUnmount() {
            emitter.off('show-alert', this.showAlert);
        },
        methods: {
            showAlert(alertVariable) {
                this.alert = alertVariable;
                setTimeout(() => {
                    this.alert.message = '';
                }, 3000);
            },
        },
    }
</script>

<style scoped>

</style>