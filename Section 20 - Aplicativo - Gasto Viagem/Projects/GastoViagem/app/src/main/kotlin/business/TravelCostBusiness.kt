package business

import business.enums.TravelCostValidateResult
import business.interfaces.IValidate
import entity.TravelCost

internal class TravelCostBusiness : IValidate<TravelCost, TravelCostValidateResult> {
    override fun validate(value: TravelCost): TravelCostValidateResult {
        with(value) {
            val fieldsToValidate = arrayOf(distance, pricePerLiter, autonomy)

            if (fieldsToValidate.contains(null))
                return TravelCostValidateResult.IncompleteFields

            if (autonomy!! <= 0)
                return TravelCostValidateResult.AutonomyIsZero

            return TravelCostValidateResult.Valid
        }
    }

    internal fun calculate(value: TravelCost): Float {
        with(value) {
            return (distance!! * pricePerLiter!!) / autonomy!!
        }
    }
}