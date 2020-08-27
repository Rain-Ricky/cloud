module.exports = {
    // 定义axios的代理，解决跨域问题
    publicPath: "/",
    // 部署应用包时的基本 URL
    outputDir: "dist",
    //输出文件目录，当运行 vue-cli-service build 时生成的生产环境构建文件的目录

    productionSourceMap: false,
    devServer: {
        // 配置webpack-dev-serve的行为 （webpack启动的本地服务器的行为）
        // 所有devserve的选项都支持
        host: "0.0.0.0",
        port: "8080",
        disableHostCheck: true,
        //关闭 HOST 检查
        hotOnly: false,
        // hot 和 hotOnly 的区别是在某些模块不支持热更新的情况下，前者会自动刷新页面，后者不会刷新页面，而是在控制台输出热更新失败

        //代理
        proxy: {
            //如果你的前端应用和后端 API 服务器没有运行在同一个主机上，你需要在开发环境下将 API 请求代理到 API 服务器

            "/api": {
                target: "http://39.100.14.147",
                // target: "http://192.168.10.103",

                changeOrigin: true,
                //上面的参数列表中有一个changeOrigin参数, 是一个布尔值, 设置为true, 本地就会虚拟一个服务器接收你的请求并代你发送该请求
                ws: true,
                //是否代理websockets

                pathRewrite: {
                    "^/api": "",
                },
                //重写路径  需要设置重写的话，要在后面的调用接口前加上/api 来代替target
            },
        },
    },
};