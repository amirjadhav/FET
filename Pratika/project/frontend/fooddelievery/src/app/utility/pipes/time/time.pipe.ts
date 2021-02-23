import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'time'
})
export class TimePipe implements PipeTransform {

  calculateTime(time1: number, time2: number, state: string, color: string): string {
    const res = Math.abs(time2 - time1);
    const time = [Math.floor((res%86400000)/3600000), Math.floor(((res%86400000)%3600000)/60000)];
    if (time[0] !== 0) {
      return "";
    }
    return `<span class="h6 ${color}">${state} in ${time[1]} min</span>`;
  }

  transform(value: Date, ...args: any[]): string {
    const default_date = "1 January, 1970";
    var end_date = default_date;
    if (parseInt(args[0]) > parseInt(args[1])) {
      end_date = "2 January, 1970";
    }
    const now = Date.parse(`${default_date}, ${value.getHours()}:${value.getMinutes()}:00 UTC`);
    const startTime = Date.parse(`${default_date}, ${args[0].slice(0, 2)}:${args[0].slice(2, 4)}:00 UTC`);
    const endTime = Date.parse(`${end_date}, ${args[1].slice(0, 2)}:${args[1].slice(2, 4)}:00 UTC`);

    if (now-startTime < 0) {
      if (args[2] === "message") {
        return this.calculateTime(now, startTime, "Opens", "text-success");
      }
      if (args[2] === "disable") {
        return "disabled-card";
      }
    } else if (now-endTime < 0) {
      if (args[2] === "message") {
        return this.calculateTime(now, endTime, "Closes", 'text-danger');
      }
      if (args[2] === "disable") {
        return "";
      }
    }
    if (args[2] === "disable") {
      return "disabled-card";
    }
    return `<span class="h6 text-danger">Closed Now</span>`;
  }

}
