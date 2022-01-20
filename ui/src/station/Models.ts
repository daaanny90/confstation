
export class Station {
    public uuid:string
    public name:string
    public event:Event
    public logo:Logo
    public lead:App
    public main:Logo
}

export class Logo {
    public src:string;
    public title:string;
}

export class App {
    public id:string;
    public name:string;
}

export class Event {
    public uuid: string;
    public name: string;
    public logo: Logo;
}