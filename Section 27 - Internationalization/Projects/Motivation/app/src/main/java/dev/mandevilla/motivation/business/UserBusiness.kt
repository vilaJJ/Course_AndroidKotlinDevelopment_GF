package dev.mandevilla.motivation.business

import dev.mandevilla.motivation.business.enums.UserValidateResult
import dev.mandevilla.motivation.business.interfaces.OnEntityValidation
import dev.mandevilla.motivation.entity.user.User

internal class UserBusiness : OnEntityValidation<User, UserValidateResult> {
    override fun validate(value: User): UserValidateResult {
        with(value) {
            if (name.isBlank())
                return UserValidateResult.InvalidName

            return UserValidateResult.Valid
        }
    }
}