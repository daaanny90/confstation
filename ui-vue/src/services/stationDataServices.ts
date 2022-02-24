import http from "@/http-common";
class StationDataService {
  get(id: number): Promise<Record<string, unknown>> {
    return new Promise((resolve, reject) => {
      http
        .get(`/station/${id}`)
        .then((res) => {
          resolve(res.data);
        })
        .catch((err) => {
          reject("Error: " + err);
        });
    });
  }
}
export default new StationDataService();
