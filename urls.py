from django.urls import path
from .views import home

urlpatterns = [
    path("", home),
]

# from django.urls import path
# from .views import api_prs_raw, prs_opened_by_period, prs_resume, prs_by_author, prs_avr_by_author, reviewers_by_period_view
# from .views import dashboard_data
# urlpatterns = [
#     path('prs-opened-by-period/', prs_opened_by_period),
#     path('prsraw/', api_prs_raw),
#     path('prs-resume/', prs_resume),
#     path('prs-by-author/', prs_by_author),
#     path('avg-time-by-author/', prs_avr_by_author),
#     path('reviewers/', reviewers_by_period_view),
#     path('dashboard/', dashboard_data),
# ]
