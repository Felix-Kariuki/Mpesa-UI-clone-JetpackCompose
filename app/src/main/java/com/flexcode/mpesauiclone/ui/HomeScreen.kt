package com.flexcode.mpesauiclone.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import com.flexcode.mpesauiclone.R
import com.flexcode.mpesauiclone.models.BottomNavigationContent
import com.flexcode.mpesauiclone.models.IconsContent
import com.flexcode.mpesauiclone.models.StatementItem
import com.flexcode.mpesauiclone.repository.StatementsRepository
import com.flexcode.mpesauiclone.ui.theme.GREENDARK
import com.flexcode.mpesauiclone.ui.theme.ORANGE

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    //Box consisting of everything acts as the "mother layout"
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column {

            val statementsRepository = StatementsRepository()
            val getAllData = statementsRepository.getAllData()
            TopSection()
            BalanceSection()
            IconsSection(
                items = listOf(
                    IconsContent(0,"Send", Color.Blue, R.drawable.transfer),
                    IconsContent(1,"Pay", Color.Blue, R.drawable.pay),
                    IconsContent(2,"Withdraw", Color.Blue, R.drawable.withdrawal),
                    IconsContent(3,"Airtime", Color.Blue, R.drawable.airtime),
                )
            )
            ExpenditureSection()
            SeeAll()
            LazyColumn(
                contentPadding = PaddingValues(all = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(items = getAllData) { index, statementItem ->
                    Log.d("TAG", index.toString())
                    StatementSection(statementItem = statementItem)
                }

            }

        }

        BottomNavigationMenu(
            items = listOf(
                BottomNavigationContent("Home", R.drawable.ic_home),
                BottomNavigationContent("transact", R.drawable.transfer),
                BottomNavigationContent("Discover", R.drawable.compass),
                BottomNavigationContent("Grow", R.drawable.charts)

            ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun TopSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.felix),
            contentDescription = "userImage",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_qr_code),
                contentDescription = "qrCode",
                tint = Color.Black,
                modifier = Modifier
                    .size(35.dp)
                    .padding(4.dp)

            )

        }


    }

}

@Composable
fun BalanceSection(
    amount: String = "53.34"
) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "BALANCE",
            style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
        )
        Text(
            text = "KSH. $amount",
            style = TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        )

    }

}

@Composable
fun IconsSection(
    items: List<IconsContent>,
    modifier: Modifier = Modifier,
    inActiveTextColor: Color = Color.DarkGray,
    initialSelectedItemIndex: Int = 0
) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
    ) {
        items.forEachIndexed { index, item ->
            IconsItems(
                item = item,
                isSelected = index == selectedItemIndex,
                inActiveTextColor = inActiveTextColor
            ) {
                selectedItemIndex = index
            }
        }

    }

}

@Composable
fun IconsItems(
    item: IconsContent,
    index: Int = 0,
    isSelected: Boolean = false,
    inActiveTextColor: Color = Color.DarkGray,
    onItemClick: () -> Unit,
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                modifier = Modifier.size(32.dp)
                    .clip(CircleShape)
                    .background(GREENDARK)
                    .padding(5.dp)
            )

        }
        Text(
            text = item.title
        )

    }

}


@Composable
fun ExpenditureSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ORANGE)
                .clip(RoundedCornerShape(12.dp))
                .padding(18.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = "TOTAL SPENT THIS WEEK",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    text = "1,700.00",
                    style = TextStyle(
                        color = Color.LightGray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {

                Text(
                    text = "DAILY AVERAGE",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    text = "KSH 700.00",
                    style = TextStyle(
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }

}

@Composable
fun StatementSection(statementItem: StatementItem) {

    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
            text = "${statementItem.initials}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Column(
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = statementItem.fullName,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Text(
                text = statementItem.phone,
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = statementItem.amount,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Right
                )

            )
            Text(
                text = statementItem.date,
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )

            )
        }
    }

}

@Composable
fun SeeAll() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "M-PESA STATEMENTS",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "SEE ALL",
                style = TextStyle(
                    color = GREENDARK,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            )
        }

    }

}


@Composable
fun BottomNavigationMenu(
    items: List<BottomNavigationContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = Color.Green,
    activeTextColor: Color = Color.Green,
    inActiveTextColor: Color = Color.Gray,
    initialSelectedItemIndex: Int = 0
) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inActiveTextColor = inActiveTextColor
            ) {
                selectedItemIndex = index
            }
        }

    }

}

@Composable
fun BottomNavigationItem(
    item: BottomNavigationContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = GREENDARK,
    activeTextColor: Color = GREENDARK,
    inActiveTextColor: Color = Color.Gray,
    onItemClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inActiveTextColor,
                modifier = Modifier.size(20.dp)
            )

        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inActiveTextColor
        )

    }

}
