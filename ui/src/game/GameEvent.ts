import type {Status} from "./Status";

export class GameEvent {
    readonly status:Status

    constructor(status: Status) {
        this.status = status;
    }
}