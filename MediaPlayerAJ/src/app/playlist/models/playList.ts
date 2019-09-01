export class PlayList {
    id:number;
    title:string;
    url:string;
    status:string;
    approved:number;
    likes:number;
    unlike:number;
    currentStatus:string;
    exitplayprogress:string;

	constructor(){
        this.id=0;
        this.title='';
        this.url='';
        this.status='';
        this.approved=0;
        this.likes=0;
        this.unlike=0;
        this.currentStatus='';
        this.exitplayprogress='';
    }
}