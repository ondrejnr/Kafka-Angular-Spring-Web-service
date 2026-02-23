import { Component, OnInit } from '@angular/core';
import { StatsService } from './services/stats.service';
import { interval } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  status: string = 'DOWN';

  constructor(private statsService: StatsService) {}

  ngOnInit() {
    // Check status immediately
    this.checkStatus();
    
    // Then check every 5 seconds (The "Heartbeat")
    interval(5000).subscribe(() => {
      this.checkStatus();
    });
  }

  checkStatus() {
    this.statsService.getBackendStatus().subscribe({
      next: (data) => this.status = data.status,
      error: () => this.status = 'OFFLINE'
    });
  }
}
