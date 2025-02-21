package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//        eventRepository.save(Event.builder()
        Organizer org1, org2, org3;
        Participant pap1, pap2, pap3, pap4, pap5;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("ChiangMai").build());

        pap1 = participantRepository.save(Participant.builder().name("BK").telNo("1234567890").build());
        pap2 = participantRepository.save(Participant.builder().name("who").telNo("1234567890").build());
        pap3 = participantRepository.save(Participant.builder().name("dad").telNo("1234567890").build());
        pap4 = participantRepository.save(Participant.builder().name("YES").telNo("1234567890").build());
        pap5 = participantRepository.save(Participant.builder().name("OKAY").telNo("1234567890").build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam NOOOOO")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        pap1.getEventHistory().add(tempEvent);
        pap4.getEventHistory().add(tempEvent);
        pap5.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        pap4.getEventHistory().add(tempEvent);
        pap2.getEventHistory().add(tempEvent);
        pap3.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        pap5.getEventHistory().add(tempEvent);
        pap4.getEventHistory().add(tempEvent);
        pap3.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        pap3.getEventHistory().add(tempEvent);
        pap4.getEventHistory().add(tempEvent);
        pap3.getEventHistory().add(tempEvent);
    }
}
