package spring.work.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService{

    private final WorkRepository workRepository;
    private final UserRepository userRepository;

    public UserService(WorkRepository workRepository, UserRepository userRepository) {
        this.workRepository=workRepository;
        this.userRepository=userRepository;
    }

    public void registWork(WorkRegisterRequest req) {
        workRepository.insert(req);
        User user=userRepository.select(req.getUser_id());
        User user2=new User(user.getUser_id(), user.getName(), user.getGender(), user.getAge(), user.getHeight(),
                user.getWeight(), user.getTotal_item(), user.getBalance()+req.getStep_num()/1000);
        userRepository.update(user2);
    }
    public List<Work> getWork(long user_id, String work_date1, String work_date2){
        return workRepository.select(user_id, work_date1, work_date2);
    }

    public StepByMonthResponse getWeekWork(long user_id) {
        List<Integer> list=new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.now();
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        if(dayOfWeekNumber==7)
            dayOfWeekNumber=0;
        for(int i=0; i<7; i++) {
            LocalDateTime t1, t2;
            if(dayOfWeekNumber-i>=0) {
                t1=dateTime.minusDays(dayOfWeekNumber-i).withHour(0).withMinute(0).withSecond(0);
                t2=dateTime.minusDays(dayOfWeekNumber-i).withHour(23).withMinute(59).withSecond(59);
            }
            else {
                t1=dateTime.plusDays(i-dayOfWeekNumber).withHour(0).withMinute(0).withSecond(0);
                t2=dateTime.plusDays(i-dayOfWeekNumber).withHour(23).withMinute(59).withSecond(59);
            }
            List<Work> work=workRepository.select(user_id, t1, t2);
            int stepSum=0;
            if(work!=null)
                for(Work w : work) {
                    stepSum+=w.getStep_num();
                }
            list.add(stepSum);
        }
        StepByMonthResponse week_step_num=new StepByMonthResponse(list);
        return week_step_num;
    }

    public StepByWeekResponse getMonthWork(long user_id) {
        List<Integer> list=new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date=dateTime.toLocalDate();
        int endDate=date.lengthOfMonth();

        DayOfWeek dayOfWeek = date.withDayOfMonth(1).getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        if(dayOfWeekNumber==7)
            dayOfWeekNumber=0;

        for(int i=0; i<5; i++) {
            LocalDateTime t1, t2;
            boolean calculateEnd=false;
            if(i==0) {
                t1=dateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
                t2=dateTime.withDayOfMonth(1).plusDays(6-dayOfWeekNumber).withHour(23).withMinute(59).withSecond(59);
            }
            else if((7-dayOfWeekNumber+(i-1)*7+1)<=endDate && (7-dayOfWeekNumber+i*7)>=endDate){
                t1=dateTime.withDayOfMonth(7-dayOfWeekNumber+(i-1)*7+1).withHour(0).withMinute(0).withSecond(0);
                t2=dateTime.withDayOfMonth(endDate).withHour(23).withMinute(59).withSecond(59);
                calculateEnd=true;
            }
            else {
                t1=dateTime.withDayOfMonth(7-dayOfWeekNumber+(i-1)*7+1).withHour(0).withMinute(0).withSecond(0);
                t2=dateTime.withDayOfMonth(7-dayOfWeekNumber+i*7).withHour(23).withMinute(59).withSecond(59);
            }

            List<Work> work=workRepository.select(user_id, t1, t2);
            int stepSum=0;
            if(work!=null)
                for(Work w : work) {
                    stepSum+=w.getStep_num();
                }
            list.add(stepSum);

            if(calculateEnd) {
                if(i==3)
                    list.add(0);
                break;
            }
        }
        StepByWeekResponse month_step_num=new StepByWeekResponse(list);
        return month_step_num;
    }

    public StepByYearResponse getYearWork(long user_id) {
        List<Integer> list=new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.now();
        for(int i=0; i<12; i++) {
            LocalDateTime t1, t2;
            LocalDate date=dateTime.toLocalDate().withMonth(i+1);
            int endDate=date.lengthOfMonth();
            t1=dateTime.withMonth(i+1).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
            t2=dateTime.withMonth(i+1).withDayOfMonth(endDate).withHour(23).withMinute(59).withSecond(59);
            List<Work> work=workRepository.select(user_id, t1, t2);
            int stepSum=0;
            if(work!=null)
                for(Work w : work) {
                    stepSum+=w.getStep_num();
                }
            list.add(stepSum);
        }
        StepByYearResponse year_step_num=new StepByYearResponse(list);
        return year_step_num;
    }
}