<template>
    <div>
        <div class="background-image">
            <div class="btn-link" @click="goTo"></div>
        </div>
    </div>
</template>



<script>

    export default {
        name: "IndexPage",
        data() {
        },
        methods: {
            goTo() {
                window.location.href = "/tech";
            },
        },
    }
</script>


<style scoped>
    .background-image {
        background-image: url('@/assets/Intro.png');
        width: 1300px;
        height: 900px;
        margin: 0 auto;
        background-size: cover;
    }
    .btn-link {
        width: 300px;
        height: 100px;
        position: relative;
        top: 530px;
        left: 485px;
        cursor: pointer;
    }
</style>
