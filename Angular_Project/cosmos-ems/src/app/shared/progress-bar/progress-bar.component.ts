import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'em-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.scss']
})
export class ProgressBarComponent implements OnInit {
 
  color:string = "";

  // @Input means, this value comes from the Parent to Child component.........
  @Input() progress:number = 0;
  @Input() firstName:string = '';

  // This is about Child to Parent 
  @Output() progressClick: EventEmitter<string> = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {

    if(this.progress < 0 || this.progress > 100){
      this.progress = 0;
    }

    if(this.progress <  35){
      this.color = 'red';
    }else if(this.progress <  75){
      this.color = 'yellow';
    }else {
      this.color = 'green';
    }

  }

// work when click on progress bar 
  onClick(){
    this.progressClick.emit(`${this.firstName}'s Progress is ${this.progress}%`);
  }

}
