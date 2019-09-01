import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { PlayList } from '../playlist/models/playList';

@Component({
  selector: 'app-control',
  templateUrl: './control.component.html',
  styleUrls: ['./control.component.css']
})
export class ControlComponent implements OnInit {
  @Input() playList: PlayList ;
  @Output() likeClicked = new EventEmitter<PlayList>();
  @Output() unlikeClicked = new EventEmitter<PlayList>();

  constructor() {}

  ngOnInit() {
  }

  addLike(playList:PlayList){
    this.likeClicked.emit(playList);
  }

  addUnLike(playList:PlayList){
    this.unlikeClicked.emit(playList);
  }
}
