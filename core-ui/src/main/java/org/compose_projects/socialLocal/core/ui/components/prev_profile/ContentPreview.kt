package org.compose_projects.socialLocal.core.ui.components.prev_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.images_profiles

@Composable
internal fun ContentPreview(contentProfile: ContentProfile) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(10.dp)
    ) {
        CurrentTitle(nameProfile = contentProfile.name)
        CurrentContent(contentProfile = contentProfile)
    }
}


@Composable
private fun CurrentTitle(nameProfile: String) {
    val currentColor by SLColor

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = nameProfile,
            style = TextStyle(
                color = currentColor.TextsColor2,
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
    }

}

@Composable
private fun CurrentContent(
    contentProfile: ContentProfile
) {
    CurrentImageProfile(imageProfile = contentProfile.image)
    CurrentDescriptionProfile(descriptionProfile = contentProfile.description)
}

@Composable
private fun CurrentImageProfile(imageProfile: String) {

    val image_profile = when (imageProfile) {
        images_profiles.uri1 -> R.drawable.image_profile1
        images_profiles.uri2 -> R.drawable.image_profile2
        images_profiles.uri3 -> R.drawable.image_profile3
        images_profiles.uri4 -> R.drawable.image_profile4
        else -> R.drawable.image_profile2
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = image_profile), contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(
                    CircleShape
                )
        )
    }

}

@Composable
private fun CurrentDescriptionProfile(descriptionProfile: String) {

    val currentColor by SLColor

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = descriptionProfile,
            style = TextStyle(
                color = currentColor.TextsColor2.copy(alpha = 0.8F),
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
        )
    }

}

