import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'time'
})
export class TimePipe implements PipeTransform {

  calculateTime(time1: number, time2: number): number[] {
    const res = Math.abs(time2 - time1);
    return [Math.floor((res%86400000)/3600000), Math.floor(((res%86400000)%3600000)/60000)];
  }

  takeDecision(time: number[]=[1,0], status: boolean=false): string {
    if (time[0] !== 0) {
      return status ? "" : `<span class="h6 text-danger">Closed Now</span>`;
    }
    return `<span class="h6 ${status ? "text-danger" : "text-success"}">${status ? "Closes" : "Opens"} in ${time[1]} min</span>`;
  }

  takeDecision1(timings: string, status: boolean=true): string {
    return `<div class="h6"><span class="${status ? "text-danger" : "text-success"}">${status ? "Closed" : "Open"} now</span> - ${timings}</div>`;
  }

  convertTime(time: string) {
    var period: string = "";
    if (parseInt(time) >= 1300) {
      time = (parseInt(time)-1200).toString();
      if (time.length === 3) {
        time = "0"+time;
      }
      period = "PM";
    } else {
      period = "AM"
    }
    return `${time.slice(0, 2)}:${time.slice(2, 4)} ${period}`;
  }

  displayTimings(time1: string, time2: string,): string {
    return `${this.convertTime(time1)} - ${this.convertTime(time2)}`;
  }

  initTime(value: Date, time1: string, time2: string) {
    const default_date = "1 January, 1970";
    var end_date = default_date;
    if (parseInt(time1) > parseInt(time2)) {
      end_date = "2 January, 1970";
    }
    const now = Date.parse(`${default_date}, ${value.getHours()}:${value.getMinutes()}:00 UTC`);
    const startTime = Date.parse(`${default_date}, ${time1.slice(0, 2)}:${time1.slice(2, 4)}:00 UTC`);
    const endTime = Date.parse(`${end_date}, ${time2.slice(0, 2)}:${time2.slice(2, 4)}:00 UTC`);

    return [now, startTime, endTime];
  }

  transform(value: Date, ...args: any[]): string {
    const dataTime = this.initTime(value, args[0], args[1]);
    const now = dataTime[0];
    const startTime = dataTime[1];
    const endTime = dataTime[2];

    if (now-startTime < 0) {
      if (args[2] === "message") {
        return this.takeDecision(this.calculateTime(now, startTime));
      }
      if (args[2] === "disable") {
        return "disabled-card";
      }
      if (args[2] === "extended-message") {
        return this.takeDecision1(this.displayTimings(args[0], args[1]));
      }
      if (args[2] === "time-status") {
        return "true";
      }
    } else if (now-endTime < 0) {
      if (args[2] === "message") {
        return this.takeDecision(this.calculateTime(now, endTime), true);
      }
      if (args[2] === "disable") {
        return "";
      }
      if (args[2] === "extended-message") {
        return this.takeDecision1(this.displayTimings(args[0], args[1]), false);
      }
      if (args[2] === "time-status") {
        return "false";
      }
    }
    if (args[2] === "disable") {
      return "disabled-card";
    }
    if (args[3] === "extended-message") {
      return this.takeDecision1(this.displayTimings(args[0], args[1]));
    }
    if (args[2] === "time-status") {
      return "true";
    }
    return this.takeDecision();
  }
}
