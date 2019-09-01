import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Subscription }   from 'rxjs';
import { PlayList } from './models/playList';
import { PlayItemService } from '../service/playerList.service';
declare function run(link): any;
@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {
  @Input() playLists: Array<PlayList> = [];
  @Output() clickedOnPlaylist = new EventEmitter<number>();
  subscription: Subscription;

  ngOnInit() {
    this.init();
  }

  constructor(private playListService:PlayItemService){}

  public run1(playList:PlayList){
    run(playList.url);
    this.clickedOnPlaylist.emit(playList.id);
  }

  init(){
    this.subscription = this.playListService.videoApproved$.subscribe(
      videoApproved => {
        this.playListService.findAllPlayList().then((res:Array<PlayList>)=> {
          this.playLists = res;
        })
    });
  }
}
