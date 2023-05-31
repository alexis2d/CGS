package fr.cgs.cgs_back.mapper;

import fr.cgs.cgs_back.dto.ClassroomDto;
import fr.cgs.cgs_back.dto.PromotionDto;
import fr.cgs.cgs_back.dto.ReservationDto;
import fr.cgs.cgs_back.dto.SiteDto;
import fr.cgs.cgs_back.entity.Classroom;
import fr.cgs.cgs_back.entity.Promotion;
import fr.cgs.cgs_back.entity.Reservation;
import fr.cgs.cgs_back.entity.Site;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Site siteDtoToSite(SiteDto siteDto);
    SiteDto siteToSiteDto(Site site);

    Classroom classroomDtoToClassroom(ClassroomDto classroomDto);
    ClassroomDto classroomToClassroomDto(Classroom classroom);

    Promotion promotionDtoToPromotion(PromotionDto promotionDto);
    PromotionDto promotionToPromotionDto(Promotion promotion);

    Reservation reservationDtoToReservation(ReservationDto reservationDto);
    ReservationDto reservationToReservationDto(Reservation reservation);

}
