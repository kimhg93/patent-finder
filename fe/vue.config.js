const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  pluginOptions: {
    vuetify: {
			// https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
		}
  }
})

module.exports = {
  // 빌드 타겟 디렉토리
  outputDir: "../src/main/resources/static",

  devServer: {
    proxy: {
      '/api': {
        // '/api' 로 들어오면 포트 8081(스프링 서버)로 보낸다
        target: 'http://localhost:8080',
        changeOrigin: true // cross origin 허용
      }
    }
  },

  pluginOptions: {
    vuetify: {}
  }
};
