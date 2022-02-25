import Station from "@/interfaces/station";
import http from "@/http-common";

export abstract class StationApi {
  static async getStation(id: number): Promise<Station[]> {
    const response = await http.get("station/" + id);
    return response.data;
  }
}
