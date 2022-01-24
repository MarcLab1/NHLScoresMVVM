package com.nhlscores.network

import com.nhlscores.model.Games
import com.nhlscores.model.Mapper

class DtoMapper : Mapper<GamesDto, Games> {
    override fun mapToDomainModel(model: GamesDto): Games {
        return Games(model.games, model.lastUpdatedOn, model.references)
    }

    override fun mapFromDomainModel(domainModel: Games): GamesDto {
        return GamesDto(domainModel.games, domainModel.lastUpdatedOn, domainModel.references)
    }
}