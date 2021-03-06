package com.cg.model;

import com.cg.model.dto.LocationRegionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location_region")
@Accessors(chain = true)
public class LocationRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String provinceId;

    @Column(nullable = false)
    private String provinceName;

    @Column(nullable = false)
    private String districtId;

    @Column(nullable = false)
    private String districtName;

    @Column
    private String wardId;

    @Column
    private String wardName;

    @Column(nullable = false)
    private String address;


    @OneToOne(mappedBy = "locationRegion")
    private Customer customer;


    @Override
    public String toString() {
        return "LocationRegion{" +
                "id=" + id +
                ", provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", districtId='" + districtId + '\'' +
                ", districtName='" + districtName + '\'' +
                ", wardId='" + wardId + '\'' +
                ", wardName='" + wardName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public LocationRegionDTO toLocationRegionDTO() {
        return new LocationRegionDTO().setId(id)
                .setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName)
                .setAddress(address);
    }
}
