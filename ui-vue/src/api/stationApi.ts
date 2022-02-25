import Axios from "axios";
import Station from "@/interfaces/station";

export abstract class StationApi {
  private static usersAxios = Axios.create({
    baseURL: "http://localhost:8080/",
  });

  static async getStation(id: number): Promise<Station[]> {
    const endpoint = "station/" + id;
    const response = await this.usersAxios.get(endpoint);
    return response.data;
  }
}
