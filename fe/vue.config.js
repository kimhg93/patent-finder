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
        target: 'http://localhost:8080',
        changeOrigin: true // cross origin 허용
      }
    }
  },

  pluginOptions: {
    vuetify: {}
  }
};
