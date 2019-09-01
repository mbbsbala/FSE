import { Component, OnInit } from '@angular/core';

declare function init(): any;
@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {
  constructor() { }

  ngOnInit() {
    this.init();
  }

  init(){}
}
