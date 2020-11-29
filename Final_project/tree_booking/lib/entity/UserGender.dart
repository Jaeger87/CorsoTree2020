enum UserGender {
  MALE, FEMALE, OTHER
}

String userGenderToString(UserGender userGender){
  return userGender.toString().split(".").last;
}

UserGender userGenderFromString(String gender){
  return UserGender.values.firstWhere((element) => userGenderToString(element) == gender, orElse: ()=>null);
}