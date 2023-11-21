import { Component } from '@angular/core';
import { TrendInfo } from '../trend-info';
import { TrendInfoService } from '../trend-info.service';

@Component({
  selector: 'app-trend-list',
  templateUrl: './trend-list.component.html'
})
export class TrendListComponent {
  trends: TrendInfo[];
currentIndex: any;
  constructor(private trendService: TrendInfoService) {}

  ngOnInit() {
    this.getTrendInfo();
  }

  private getTrendInfo(){
    this.trendService.getTrendInfo().subscribe(data => {
      this.trends = data;
    });
  }


}
