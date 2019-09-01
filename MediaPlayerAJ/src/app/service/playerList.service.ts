import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { PlayList } from '../playlist/models/playList';

const baseUrl: string = 'http://localhost:3000/playlist/';

@Injectable()
export class PlayItemService {
    private videoApprovedsource = new Subject<any>();

    // Observable string streams
    videoApproved$ = this.videoApprovedsource.asObservable();

    // Service message commands
    videoApproved(playItems: any) {
        this.videoApprovedsource.next();
    }
    
    constructor(private http: HttpClient) {}

    addVideo(playItem: any){
        this.findAllPlayList().then((res:Array<PlayList>)=> {
            playItem.id = res[res.length].id+1
        });
        return this.http.post(baseUrl, playItem).toPromise();
    }

    deleteVideo(id: number){
        return this.http.delete(baseUrl + id).toPromise();
    }

    editVideo(playItem: any){
        return this.http.put(baseUrl+playItem.id, playItem).toPromise();
    }

    findAllPlayList(){
        return this.http.get(baseUrl).toPromise();
    }

    findPlayListById(id:number){
        return this.http.get(baseUrl+id).toPromise();
    }
}