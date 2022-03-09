module.exports = {
  css: {
    loaderOptions: {
      sass: {
        prependData: `
        @import "@/globals/scss/_variables.scss";
        @import "@/globals/scss/_bootstrap-override.scss";
        @import "@/globals/scss/_global.scss";
        @import "./node_modules/bootstrap/scss/bootstrap.scss";
        `
      }
    }
  }
};