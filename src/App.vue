<template>
  <div class="container app-container d-flex flex-column">
    <Header v-if="station.logo" :stationLogo="station.logo.src" />
    <div v-else>Loading...</div>

    <div v-if="isLoading">Loading...</div>

    <div class="container main" v-if="!isLoading && stationExsist">
      <router-view :station="station" />
    <router-link v-if="$route.name === 'Home'" to="/intro"><Button text="START DEMO" /> </router-link>
    </div>
    <div v-else-if="!isLoading && !stationExsist">NO STATION</div>
    <Footer />
  </div>
</template>

<script lang="ts">
import { Vue, Options } from "vue-class-component";
import { StationApi } from "@/api/stationApi";
import Station from "@/interfaces/station";
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import Button from "@/components/Button.vue";

@Options({
  components: {
    Header,
    Footer,
    Button,
  },
})
export default class App extends Vue {
  serviceID = process.env.VUE_APP_DEV_STATION_ID;
  station: Station[] = [];
  stationExsist = false;
  isLoading = false;
  stationLogo = "";
  isNetlify = true;

  getStation = async (): Promise<void> => {
    if (this.isNetlify) {
      // @ts-ignore
      this.station = {
        // @ts-ignore
        uuid: "1001",
        name: "Station-1001",
        event: {
          uuid: "ev-1001",
          name: "Event-1001",
          logo: {
            src: "https://www.itsax.de/system/organisations/logos/194/facebook/logo.png20211027-17220-1jsetmo.jpg?1635365334",
            title: "ostec-1001",
          },
        },
        logo: {
          src: "https://b2ms.de/wp-content/uploads/2019/08/logo.png",
          title: "title-1001",
        },
        theme: { css: "div {color:red; background-color:blue}" },
      };
      this.stationExsist = true;
      this.isLoading = false;
      return;
    }
    this.isLoading = true;
    await StationApi.getStation(this.serviceID).then((response) => {
      this.station = response;
      this.isLoading = false;
    });

    if (this.station !== null) {
      this.stationExsist = true;
      return;
    }

    this.stationExsist = false;
  };

  mounted(): void {
    this.getStation();
  }
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}

.app-container {
  height: 100%;
  max-height: 53rem;
}

.main {
  padding: 2rem 0;
  height: 100%;
  flex: 1;
}
</style>
