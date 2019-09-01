import { Component, OnInit } from '@angular/core';
import { PlayItemService } from '../service/playerList.service';
import { PlayList } from '../playlist/models/playList';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css']
})
export class VideoComponent implements OnInit {
  playList: PlayList ;
  playLists: Array<PlayList> = [];
  title = 'myPlayer';

  constructor(private playListService:PlayItemService) { }

  ngOnInit(){
    this.init();
  }

  init(){
    this.playListService.findAllPlayList().then((res:Array<PlayList>)=> {
      this.playLists = res;
    });
   this.findAllPlayList(1);
  }

  public  onPlaylistClicked (id:number){
    this.findAllPlayList(id);
  }

  public onLikeClicked (playList:PlayList){
    playList.likes=playList.likes+1;
    this.playListService.editVideo(playList).then((res:PlayList)=> {
      this.playList = res;
    });
  }

  public onUnlikeClicked(playList:PlayList){
    playList.unlike=playList.unlike+1;
    this.playListService.editVideo(playList).then((res:PlayList)=> {
      this.playList = res;
    });
  }

  public findAllPlayList(id:number){
    this.playListService.findPlayListById(id).then((res:PlayList)=> {
      this.playList = res
    });
  }
}
