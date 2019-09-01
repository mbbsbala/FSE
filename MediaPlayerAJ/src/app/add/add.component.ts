import { Component, OnInit } from '@angular/core';
import { PlayItemService } from '../service/playerList.service';
import { PlayList } from '../playlist/models/playList';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  playLists: Array<PlayList> = [];
  urlError:String;
  titleError:String;

  constructor(private playListService:PlayItemService){}

  ngOnInit(){
    this.init();
  }

  init(){
    this.playListService.findAllPlayList().then((res:Array<PlayList>)=> {
      this.playLists = res;
    });
  }

  public onAddVideo(addVideo:any){
    let body = {id:0,title:addVideo.title, url:addVideo.url,status:'added',approved:0,likes:0,unlike:0}
    this.playListService.addVideo(body).then( (res:any)=> {
      this.findAllPlayList();
    })
    alert('Successfully added');
  }

  public approveVideo(playList:PlayList){
    playList.approved=1;
    this.playListService.editVideo(playList).then( (res:any)=> {
      this.findAllPlayList();
      this.playListService.videoApproved(1);
    })
    this.playListService.videoApproved(1);
  }

  public editVideo(playItem:PlayList){
    alert(playItem.url);
  }

  public deleteVideo(id:number){
    this.playListService.deleteVideo(id)
    .then((res:any)=> {
      this.findAllPlayList();
      this.playListService.videoApproved(1);
    });
  }

  public findAllPlayList(){
    this.playListService.findAllPlayList()
    .then((res:Array<PlayList>)=> {
      this.playLists = res;
    });
  }
}
